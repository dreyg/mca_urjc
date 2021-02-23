const moment = require('moment');
const mongoosePaginate = require('mongoose-paginate');

function create(mongoose) {

    const productSchema = mongoose.Schema({
        name: {
            type: String,
            required: true,
        },
        description: String,
    });


    productSchema.pre('save', (next) => {
        this.created = moment().toJSON();
        return next();
    });

    productSchema.index({ created: -1 });

    productSchema.plugin(mongoosePaginate);

    return mongoose.model('Product', productSchema);
}

module.exports = create;
