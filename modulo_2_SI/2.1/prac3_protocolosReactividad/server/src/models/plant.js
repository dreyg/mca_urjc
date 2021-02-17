const { Sequelize, Model, DataTypes } = require('sequelize');
const database = require('./database.js');

    let sequelize = database.sequelize;

    let Plant = class extends Model { }

    Plant.init({
        "id": DataTypes.NUMBER_TYPE,
        "city": DataTypes.STRING,
        "progress": DataTypes.NUMBER_TYPE,
        "completed": DataTypes.Boolean,
        "planning": DataTypes.STRING

    }, { sequelize, modelName: 'plant' });



module.exports = { Plant }
