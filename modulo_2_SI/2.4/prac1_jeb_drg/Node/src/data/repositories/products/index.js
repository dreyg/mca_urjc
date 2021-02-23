const mapper = require('../../mapper');
const productDomainModel = require('../../../domain/product/model');



const productStore = {
    async createProduct(options) {
        try {
            const { Product: productSchema } = this.getSchemas();
            const newProduct = new productSchema({
                name: options.name,
                description: options.description,
            });


            const doc = await newProduct.save();
            return mapper.toDomainModel(doc, productDomainModel);
        } catch (error) {
            throw error;
        }
    },

    async findProductById(options) {
    try {
        const { Product: productSchema } = this.getSchemas();
        const doc = await productSchema.findOne({ _id: options.productId }).lean().exec();
        if (!doc) {
            throw new errors.NotFound(`Product with id ${options.productId} not found.`);
        }
        return mapper.toDomainModel(doc, productDomainModel);
    } catch (error) {
        throw error;
    }
  },

    async findAllProducts() {
        try {
            const { Product: productSchema } = this.getSchemas();
            const doc = await productSchema.find({}).lean().exec();
            return mapper.toDomainModel(doc, productDomainModel);
        } catch (error) {
            throw error;
        }
    },

    async deleteProductById(options) {
        try {
            const { Product: productSchema } = this.getSchemas();
            //const doc = await productSchema.findOne({ _id: options.productId }).lean().exec();

            const doc = await productSchema.findByIdAndDelete({ _id: options.productId });


            return mapper.toDomainModel(doc, productDomainModel);
        } catch (error) {
            throw error;
        }
    },


};
module.exports.init = ({ Product }) => Object.assign(Object.create(productStore), {
    getSchemas() {
        return {
            Product,
        };
    },
});


