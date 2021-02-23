const moment = require('moment');
const mongoosePaginate = require('mongoose-paginate');

function create(mongoose) {

    const shoppingCartSchema = mongoose.Schema({
        userId: {
            type: mongoose.Schema.Types.ObjectId,
            ref: 'User',
        },
        imageUrl: {
            type: String,
            required: true,
        },
        description: String,
        publisher: {
            type: String,
            required: true,
        },
        created: Date,
    });

    shoppingCartSchema.pre('save', (next) => {
        this.created = moment().toJSON();
        return next();
    });

    shoppingCartSchema.index({ created: -1 });

    shoppingCartSchema.plugin(mongoosePaginate);

    return mongoose.model('ShoppingCart', shoppingCartSchema);
}

module.exports = create;
