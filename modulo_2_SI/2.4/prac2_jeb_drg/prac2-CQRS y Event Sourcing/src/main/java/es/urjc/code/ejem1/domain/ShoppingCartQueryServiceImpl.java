package es.urjc.code.ejem1.domain;

import org.modelmapper.ModelMapper;


public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService {

	private ShoppingCartRepository shoppingCartRepository;
	private ProductRepository productRepository;
	private ValidationService validationService;
	private ShoppingExpenditureService shoppingExpenditureService;

	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                        ProductRepository productRepository,
                                        ValidationService validationService,
                                        ShoppingExpenditureService shoppingExpenditureService) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.validationService = validationService;
		this.shoppingExpenditureService = shoppingExpenditureService;
	}
	
	@Override
	public FullShoppingCartDTO getShoppingCart(Long id) {
		return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
	}

}
