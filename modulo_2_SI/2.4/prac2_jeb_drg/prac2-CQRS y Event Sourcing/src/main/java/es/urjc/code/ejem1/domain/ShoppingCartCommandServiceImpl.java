package es.urjc.code.ejem1.domain;

import org.modelmapper.ModelMapper;


public class ShoppingCartCommandServiceImpl implements ShoppingCartCommandService {

	private ShoppingCartRepository shoppingCartRepository;
	private ProductRepository productRepository;
	private ValidationService validationService;
	private ShoppingExpenditureService shoppingExpenditureService;
	private ShoppingCartPublishService shoppingCartPublishService;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartCommandServiceImpl(ShoppingCartRepository shoppingCartRepository,
										  ProductRepository productRepository,
										  ValidationService validationService,
										  ShoppingExpenditureService shoppingExpenditureService,
										  ShoppingCartPublishService shoppingCartPublishService) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.validationService = validationService;
		this.shoppingExpenditureService = shoppingExpenditureService;
		this.shoppingCartPublishService = shoppingCartPublishService;
	}
	
	private void saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		ShoppingCartEventDTO shoppingCartEventDTO = mapper.map(fullShoppingCartDTO, ShoppingCartEventDTO.class);
		shoppingCartEventDTO.setTypeOperation(1);
		shoppingCartPublishService.publishEvent(shoppingCartEventDTO);
	}

	@Override
	public void createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		saveShoppingCart(fullShoppingCartDTO);
	}

	@Override
	public void deleteProduct(Long idShoppingCart, Long idProduct) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(idProduct);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		saveShoppingCart(newFullProductDTO);
	}





	@Override
	public void updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(shoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
		        updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
			shoppingCart.setValidationService(validationService);
			shoppingCart.validate();
		}

		if(shoppingCart.getStatus() == ShoppingCartStatus.COMPLETED){
			shoppingCartDTO = mapper.map(shoppingCart, ShoppingCartDTO.class);
			ShoppingExpenditureDTO shoppingExpenditureEventDTO = mapper.map(shoppingCartDTO, ShoppingExpenditureDTO.class);
			shoppingExpenditureService.publishEvent(shoppingExpenditureEventDTO);
		}

		FullShoppingCartDTO newShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		saveShoppingCart(newShoppingCartDTO);
	}

	@Override
	public void deleteShoppingCart(Long id) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);
		ShoppingCartEventDTO shoppingCartEventDTO = mapper.map(fullShoppingCartDTO, ShoppingCartEventDTO.class);
		shoppingCartEventDTO.setTypeOperation(2);
		shoppingCartPublishService.publishEvent(shoppingCartEventDTO);
	}

	@Override
	public void addProduct(Long idShoppingCart, Long idProduct, int quantity) {
		FullProductDTO fullProductDTO = productRepository.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		addProduct(fullProductDTO, fullShoppingCartDTO, quantity);
	}

	public void addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCart.addItem(shoppingCartItem);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		saveShoppingCart(newFullProductDTO);
	}



}
