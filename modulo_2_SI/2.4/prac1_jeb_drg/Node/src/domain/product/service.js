function init({
                  productsRepository,
              }) {

    async function createProduct({
                                      id,
                                      name,
                                      description,
                                  }) {
        return productsRepository.createProduct({
            id,
            name,
            description,
        });
    }

    async function findAllProducts() {

        return productsRepository.findAllProducts([{
        }]);

    }

    async function findProductById({
                                       productId,
                               })
    {

        return productsRepository.findProductById({
            productId
        });
    }

    async function deleteProductById({
                                         productId,
                                   }) {
        return productsRepository.deleteProductById({
            productId
        });
    }

    return {
        createProduct,
        findAllProducts,
        findProductById,
        deleteProductById,
    };
}

module.exports.init = init;
