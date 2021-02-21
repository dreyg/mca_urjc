function init({productRepository}) {

    console.log("testproductRepository");
    console.log(productRepository);

    async function createProduct({
                                      id,
                                      name,
                                      description,
                                  }) {
        return productRepository.createProduct({
            id,
            name,
            description,
        });
    }

    async function findAllProducts() {

        return productRepository.findAllProducts([{
                id,
                name,
                description,
        }]);

    }

    async function findProductById({
                                     id,
                               }) {
        return productRepository.findProductById({
            id,
            name,
            description,
        });
    }

    async function deleteProductById({
                                       id,
                                   }) {
        return productRepository.deleteProductById({
            id,
            name,
            description,
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
