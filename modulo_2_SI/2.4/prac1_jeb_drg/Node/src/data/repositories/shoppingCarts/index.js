const mapper = require('../../mapper');
const shoppingCartDomainModel = require('../../../domain/shoppingCart/model');



const shoppingCartStore = {
    async createShoppingCart(options) {
        try {
            const { ShoppingCart: shoppingCartSchema } = this.getSchemas();
            const newShoppingCart = new shoppingCartSchema({
                name: options.name,
                description: options.description,
            });


            const doc = await newShoppingCart.save();
            return mapper.toDomainModel(doc, shoppingCartDomainModel);
        } catch (error) {
            throw error;
        }
    },

    async updateShoppingCart(options) {
    try {
        const { ShoppingCart: shoppingCartSchema } = this.getSchemas();
        const doc = await shoppingCartSchema.findOne({ _id: options.productId }).lean().exec();
        if (!doc) {
            throw new errors.NotFound(`Product with id ${options.productId} not found.`);
        }
        return mapper.toDomainModel(doc, shoppingCartDomainModel);
    } catch (error) {
        throw error;
    }
  },

    async findShoppingCartById() {
        try {
            const { ShoppingCart: shoppingCartSchema } = this.getSchemas();
            const doc = await shoppingCartSchema.find({}).lean().exec();
            return mapper.toDomainModel(doc, shoppingCartDomainModel);
        } catch (error) {
            throw error;
        }
    },

    async addProductToShoppingCart(options) {
        try {
            const { ShoppingCart: shoppingCartSchema } = this.getSchemas();
            //const doc = await shoppingCartSchema.findOne({ _id: options.productId }).lean().exec();

            const doc = await shoppingCartSchema.findByIdAndDelete({ _id: options.productId });


            return mapper.toDomainModel(doc, shoppingCartDomainModel);
        } catch (error) {
            throw error;
        }
    },

    async deleteProductFromShoppingCart(options) {
        try {
            const { ShoppingCart: shoppingCartSchema } = this.getSchemas();
            //const doc = await shoppingCartSchema.findOne({ _id: options.productId }).lean().exec();

            const doc = await shoppingCartSchema.findByIdAndDelete({ _id: options.productId });


            return mapper.toDomainModel(doc, shoppingCartDomainModel);
        } catch (error) {
            throw error;
        }
    },




};
module.exports.init = ({ ShoppingCart }) => Object.assign(Object.create(shoppingCartStore), {
    getSchemas() {
        return {
            ShoppingCart,
        };
    },
});


