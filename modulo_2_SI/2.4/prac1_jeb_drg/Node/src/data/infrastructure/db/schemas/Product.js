function create(mongoose) {
    const productSchema = mongoose.Schema({
        id: {
            type: mongoose.Schema.Types.ObjectId,
        },
        name: {
            type: String,
            required: true,
        },
        description: String,
    });

    productSchema.pre('save', (next) => {
        return next();
    });

    return mongoose.model('Product', productSchema);
}

module.exports = create;
