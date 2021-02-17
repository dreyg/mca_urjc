
http://localhost:8080/books/ - GET

Body: null

Response:
[
{
"id": 0,
"user": "Pedro",
"title": "El Mundo Amarillo",
"resume": "si crees en los sueños, ellos se crearán",
"author": "Albert Espinosa",
"editorial": "Grijalbo",
"publishYear": 2010,
"commentsList": [
{
"id": null,
"comment": "Libro TOP",
"user": "Pedro",
"score": 5
}
]
},
{
"id": 1,
"user": "Luis",
"title": "La fuerza de uno",
"resume": "Un niño que lucha y siempre se levanta",
"author": "Bryce Courtenay",
"editorial": "Diagonal",
"publishYear": 2002,
"commentsList": [
{
"id": null,
"comment": "Libro TOP",
"user": "Pedro",
"score": 5
}
]
}
]

http://localhost:8080/books/1 - GET

Body: null

Response:
{
"id": 1,
"user": "Luis",
"title": "La fuerza de uno",
"resume": "Un niño que lucha y siempre se levanta",
"author": "Bryce Courtenay",
"editorial": "Diagonal",
"publishYear": 2002,
"commentsList": [
{
"id": null,
"comment": "Libro TOP",
"user": "Pedro",
"score": 5
}
]
}

http://localhost:8080/books/ - POST

Body:
{
"user": "Alberto",
"title": "El Mundo Amarillo2",
"resume": "si crees en los sueños, ellos se crearán",
"author": "Albert Espinosa",
"editorial": "Grijalbo",
"publishYear": 2012
}

Response:
{
"id": 3,
"user": "Alberto",
"title": "El Mundo Amarillo2",
"resume": "si crees en los sueños, ellos se crearán",
"author": "Albert Espinosa",
"editorial": "Grijalbo",
"publishYear": 2012,
"commentsList": null
}

http://localhost:8080/books/0/comments/ - POST

body:
{
"comment": "Libro TOPPPPP",
"user": "Pedro",
"score": 5
}

Response:
{
"id": 0,
"user": "Pedro",
"title": "El Mundo Amarillo",
"resume": "si crees en los sueños, ellos se crearán",
"author": "Albert Espinosa",
"editorial": "Grijalbo",
"publishYear": 2010,
"commentsList": [
{
"id": null,
"comment": "Libro TOP",
"user": "Pedro",
"score": 5
},
{
"id": 2,
"comment": "Libro TOPPPPP",
"user": "Pedro",
"score": 5
}
]
}

http://localhost:8080/books/0/comments/0 - DELETE

Body: null

Response:
{
    "id": null,
    "comment": "Libro TOP",
    "user": "Pedro",
    "score": 5
}