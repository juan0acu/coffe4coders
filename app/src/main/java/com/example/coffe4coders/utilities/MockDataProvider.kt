package com.example.coffe4coders.utilities

import com.example.coffe4coders.models.Product

class MockDataProvider {
    companion object{
        fun listOfProducts(): List<Product>{
            return listOf(
            Product(
                0,
                "Café de Colombia",
                "Nuestro esfuerzo y trabajo en conjunto representa el sueño de toda una nación",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
                55.0,
                "USD",
                "COL"
            ),
            Product(
            1,
            "Café de Costa Rica",
            "Nuestro esfuerzo y trabajo en conjunto representa el sueño de toda una nación",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
            45.0,
            "USD",
            "CRI"
            ),
                Product(
                    2,
                    "Café de Nicaragua",
                    "Nuestro esfuerzo y trabajo en conjunto representa el sueño de toda una nación",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
                    35.0,
                    "USD",
                    "NIC"
                ),
                Product(
                    3,
                    "Café de Brazil",
                    "Nuestro esfuerzo y trabajo en conjunto representa el sueño de toda una nación",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
                    30.0,
                    "USD",
                    "BRA"
                )
            )
        }

        fun getProductBy(id: Int) : Product?{
            val list = MockDataProvider.listOfProducts()
            val product = list.find { it.id == id}
            return product
        }

        fun listOfCities(): List<String>{
            return listOf(
                "Ciudad de Mexico, Mexico",
                "La Habana, Cuba",
                "Buenos Aires, Argentina",
                "Bogota, Colombia",
                "Anzoategui, Venezuela",
                "Curicó, Chile"
            )
        }
    }
}