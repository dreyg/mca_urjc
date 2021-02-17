const mysql = require('mysql2/promise');
const { Sequelize, Model, DataTypes } = require('sequelize');
const Plant = require('./models/plant.js').Plant;

    let seq;

async function connect() {

    seq = new Sequelize('test', 'root', 'pass', {
        dialect: 'mysql'
    })

    console.log("Connected to MySQL");

    await init();

    await seq.sync();

}

async function disconnect() {
    await seq.end();
    console.log("Disconnected from MySQL")
}


async function init() {

    console.log('Initializing database');
    await Plant.destroy();
    console.log('Database initialized');
}

module.exports = { connect, disconnect }