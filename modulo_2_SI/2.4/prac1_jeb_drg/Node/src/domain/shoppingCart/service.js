function init({
                  shoppingCartRepository,
              }) {

    async function createShoppingCart({
                                     status,
                                 }) {
        return shoppingCartRepository.createShoppingCart({
            status,
        });
    }

    async function updateShoppingCart({
                                          shoppingCartId,
                                      }) {

        return shoppingCartRepository.updateShoppingCart([{shoppingCartId
        }]);

    }

    async function findShoppingCartById({
                                            shoppingCartId,
                                   })
    {

        return shoppingCartRepository.findShoppingCartById({
            shoppingCartId
        });
    }

    async function deleteShoppingCart({
                                            shoppingCartId,
                                        })
    {

        return shoppingCartRepository.deleteShoppingCart({
            shoppingCartId
        });
    }


    async function addProductToShoppingCart({
                                     shoppingCartId,
                                     cartProduct,
                                 }) {
        return shoppingCartRepository.addProductToShoppingCart({
            shoppingCartId,
            cartProduct,
        });
    }



    async function deleteProductFromShoppingCart({
                                         shoppingCartId,
                                     }) {
        return shoppingCartRepository.deleteProductFromShoppingCart({
            shoppingCartId
        });
    }

    return {
        createShoppingCart,
        updateShoppingCart,
        findShoppingCartById,
        deleteShoppingCart,
        addProductToShoppingCart,
        deleteProductFromShoppingCart,
    };
}

module.exports.init = init;
