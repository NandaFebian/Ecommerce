# e-COMMERCE

### I Putu Nanda Febian Danan Jaya
2205551093

## About
Program ini bertujuan untuk membuat backend API untuk aplikasi e-commerce sederhana yang nantinya memberikan response dengan format JSON. Adapun request method pada API memuat: <br/>
**GET** untuk mendapatkan list atau detail data dari entitas. <br/>
**POST** untuk membuat data entitas baru. <br/>
**PUT** untuk mengubah data dari entitas. <br/>
**DELETE** untuk menghapus data dari entitas. <br/>

Data-data yang digunakan dalam aplikasi e-Commerce ini akan disimpan pada **DataBase SQLite** yang kemudian akan dilakukan suatu pengujian API yang telah diprogram melalui aplikasi **Postman**

## Spesifikasi API dalam Aplikasi e-Commerce 
### **GET**

- GET /users untuk mendapatkan daftar semua user yang termuat di dalam database. <br/>
'http://localhost:8093/users'

'''
[

    {
        "firstName": "John",
        "lastName": "Doe",
        "addresses": [],
        "phoneNumber": "08123456789",
        "id": 1,
        "type": "Seller",
        "email": "john.doe@example.com"
    },
    {
        "firstName": "Jane",
        "lastName": "Smith",
        "addresses": [],
        "phoneNumber": "08234567890",
        "id": 2,
        "type": "Buyer",
        "email": "jane.smith@example.com"
    },
    {
        "firstName": "Ahmad",
        "lastName": "Hidayat",
        "addresses": [],
        "phoneNumber": "08345678901",
        "id": 3,
        "type": "Seller",
        "email": "ahmad.hidayat@example.com"
    },
    {
        "firstName": "Maria",
        "lastName": "Garcia",
        "addresses": [],
        "phoneNumber": "08456789012",
        "id": 4,
        "type": "Buyer",
        "email": "maria.garcia@example.com"
    },
    {
        "firstName": "Andi",
        "lastName": "Santoso",
        "addresses": [],
        "phoneNumber": "08567890123",
        "id": 5,
        "type": "Seller",
        "email": "andi.santoso@example.com"
    },
    {
        "firstName": "Siti",
        "lastName": "Yulianti",
        "addresses": [],
        "phoneNumber": "08678901234",
        "id": 6,
        "type": "Buyer",
        "email": "siti.yulianti@example.com"
    },
    {
        "firstName": "Budi",
        "lastName": "Susanto",
        "addresses": [],
        "phoneNumber": "08789012345",
        "id": 7,
        "type": "Seller",
        "email": "budi.susanto@example.com"
    },
    {
        "firstName": "Linda",
        "lastName": "Wijaya",
        "addresses": [],
        "phoneNumber": "08890123456",
        "id": 8,
        "type": "Buyer",
        "email": "linda.wijaya@example.com"
    },
    {
        "firstName": "Rahmat",
        "lastName": "Saputra",
        "addresses": [],
        "phoneNumber": "08901234567",
        "id": 9,
        "type": "Seller",
        "email": "rahmat.saputra@example.com"
    },
    {
        "firstName": "Anita",
        "lastName": "Sari",
        "addresses": [],
        "phoneNumber": "08912345678",
        "id": 10,
        "type": "Buyer",
        "email": "anita.sari@example.com"
    }
]
'''

<br/>

- GET /users/{id} untuk mendapatkan informasi user dan alamatnya. <br/>
'http://localhost:8093/users/7' 

'''
[

    {
        "firstName": "Budi",
        "lastName": "Susanto",
        "addresses": [Bandung],
        "phoneNumber": "08789012345",
        "id": 7,
        "type": "Seller",
        "email": "budi.susanto@example.com"
    }
]
'''

<br/>

- GET /users/{id}/products untuk mendapatkan daftar produk milik user. <br/>
'http://localhost:8093/users/7/products' 

'''
[

    {
        "seller": 7,
        "price": "80000",
        "description": "Topi baseball dengan desain sporty dan bahan berkualitas.",
        "id": 7,
        "title": "Topi Baseball",
        "stock": 25
    }
]
'''

<br/>

- GET /users/{id}/orders untuk mendapatkan daftar order milik user. <br/>
'http://localhost:8093/users/7/orders' 

'''
[
    
    {
        "note": 1007,
        "total": 600000,
        "discount": 25000,
        "id": 7,
        "is_paid": "1",
        "buyer": 7
    }
]
'''

<br/>

- GET /users/{id}/reviews untuk mendapatkan daftar review yang dibuat oleh user. <br/>
'http://localhost:8093/users/7/reviews' 

'''
[

    {
        "nama": "Budi",
        "star": 5,
        "description": "Produk sangat berkualitas dan pengiriman sangat cepat.",
        "order": 7
    }
]
'''

<br/>

- GET /orders/{id} untuk mendapatkan informasi order, buyer, detail order, review, product title, beserta pricenya. <br/>
'http://localhost:8093/orders/7' 

'''
[

    {
        "note": 1007,
        "total": 600000,
        "reviews": [
            {
                "star": 5,
                "description": "Produk sangat berkualitas dan pengiriman sangat cepat."
            }
        ],
        "discount": 25000,
        "id": 7,
        "is_paid": "1",
        "order_detail": [
            {
                "product": "Topi Baseball",
                "quantity": 2,
                "price": 80000
            }
        ],
        "buyer": 7
    }
]
'''

<br/>

- GET /products untuk mendapatkan daftar semua produk. <br/>
'http://localhost:8093/products' 

'''
[

    {
        "seller": 1,
        "price": "500000",
        "description": "Sepatu sneakers dengan desain modern dan nyaman digunakan sehari-hari.",
        "id": 1,
        "title": "Sepatu Sneakers",
        "stock": 10
    },
    {
        "seller": 2,
        "price": "150000",
        "description": "Baju kaos polos dengan bahan katun yang lembut dan nyaman.",
        "id": 2,
        "title": "Baju Kaos Polos",
        "stock": 20
    },
    {
        "seller": 3,
        "price": "200000",
        "description": "Tas ransel dengan banyak kantong yang cocok untuk kegiatan sehari-hari.",
        "id": 3,
        "title": "Tas Ransel",
        "stock": 15
    },
    {
        "seller": 4,
        "price": "300000",
        "description": "Celana jeans dengan potongan slim fit dan bahan denim berkualitas.",
        "id": 4,
        "title": "Celana Jeans",
        "stock": 8
    },
    {
        "seller": 5,
        "price": "400000",
        "description": "Jam tangan pria dengan tampilan elegan dan mekanisme quartz.",
        "id": 5,
        "title": "Jam Tangan Pria",
        "stock": 12
    },
    {
        "seller": 6,
        "price": "250000",
        "description": "Kemeja wanita dengan motif bunga yang cantik dan nyaman dipakai.",
        "id": 6,
        "title": "Kemeja Wanita",
        "stock": 18
    },
    {
        "seller": 7,
        "price": "80000",
        "description": "Topi baseball dengan desain sporty dan bahan berkualitas.",
        "id": 7,
        "title": "Topi Baseball",
        "stock": 25
    },
    {
        "seller": 8,
        "price": "100000",
        "description": "Sandal jepit dengan sol karet yang nyaman saat digunakan.",
        "id": 8,
        "title": "Sandal Jepit",
        "stock": 30
    },
    {
        "seller": 9,
        "price": "350000",
        "description": "Kacamata sunglasses dengan lensa polarized untuk melindungi mata dari sinar UV.",
        "id": 9,
        "title": "Kacamata Sunglasses",
        "stock": 6
    },
    {
        "seller": 10,
        "price": "180000",
        "description": "Tas selempang dengan tali yang dapat disesuaikan dan banyak kantong.",
        "id": 10,
        "title": "Tas Selempang",
        "stock": 15
    }
]
'''

<br/>

- GET /products/{id} untuk mendapatkan informasi produk dan seller. <br/>
'http://localhost:8093/products/7' 

''''
[

    {
        "seller": 7,
        "price": "80000",
        "description": "Topi baseball dengan desain sporty dan bahan berkualitas.",
        "id": 7,
        "title": "Topi Baseball",
        "stock": 25
    }
]
''''

<br/>

### **POST**
- Menambahkan data baru kedalam tabel users <br/>

''''

    {
    "id":"11",
    "first_name":"Nanda",
    "last_name":"Febian",
    "email":"nanda@gmail.com",
    "phone_number":"081236627844",
    "type":"Seller"
    }

''''

<br/>

- Membuat entitas baru berupa tabel products<br/>

'''

    {
    "id":"11",
    "seller":"Fiesta",
    "title":"Chicken Nugget",
    "description":"Nugget dengan bahan ayam asli",
    "price":"50000",
    "stock":"50"
    }

'''

<br/>

- Membuat entitas baru berupa tabel orders <br/>

'''

    {
    "id":"11",
    "buyer":"11",
    "note":"11",
    "total":"100000",
    "discount":"15000",
    "is_paid":"1"
    }

'''

<br/>

### **PUT**
- Mengubah data user dengan id 7 pada tabel users<br/>

'''

    {
    "id":"",
    "first_name":"Nanda",
    "last_name":"Febian Danan Jaya",
    "email":"nanda@gmail.com",
    "phone_number":"081236627844",
    "type":"Seller"
    }
'''
![Put](/img/1.png "Put")

<br/>

### **DELETE**
- Menghapus data user dengan id 7 pada tabel users <br/>

![Delete](/img/2.png"Delete")

<br/>