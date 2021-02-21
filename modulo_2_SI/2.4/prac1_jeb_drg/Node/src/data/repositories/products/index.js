const mapper = require('../../mapper');
const productDomainModel = require('../../../domain/product/model');

const productStore = {
    async createProduct() {
        try {
            const { Product: productSchema } = this.getSchemas();
            const newProduct = new productSchema({
                id: id,
                name: name,
                description: description,
            });
            const doc = await newProduct.save();
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

