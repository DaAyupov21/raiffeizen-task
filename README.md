# Тестовое задание для Java стажеров

## Что нужно сделать

Реализовать приложение для автоматизации учёта носков на складе магазина. Кладовщик должен иметь возможность:

* учесть приход и отпуск носков;
* узнать общее количество носков определенного цвета и состава в данный момент времени.


###Примеры запросов
```GET https://raiffeizentesttask.herokuapp.com/api/socks?color=purple&operation=moreThan&cottonPart=10

###

GET https://raiffeizentesttask.herokuapp.com/api/socks?color=white&operation=lessThan&cottonPart=50

###

POST https://raiffeizentesttask.herokuapp.com/api/socks/income
Content-Type: application/json

{
  "color": "purple",
  "cottonPart": 30,
  "quantity": 2120
}

###

POST https://raiffeizentesttask.herokuapp.com/api/socks/outcome
Content-Type: application/json

{
  "color": "white",
  "cottonPart": 5,
  "quantity": 2000
}```