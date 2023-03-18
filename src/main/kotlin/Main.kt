fun main(args: Array<String>) {
    val discount = 100                   //скидка до 1_000 руб
    val discountFirst = 1_000            //первая сумма, после которой действует скидка - 100р
    val discountSecond = 10_000          //вторая сумма, после которой действует скидка - 5%
    val result: Int                      //храним результат
    val unRegularUser = "Вы не постоянный покупатель!\nСумма вашей покупки без скидки 1% составит: "
    val regularUser = "Вы постоянный покупатель!\nСумма вашей покупки со скидкой 1% составит: "

    println(
        "Покупка до 1.000 - скидка 0%\n" +
                "От 1.001 до 10.000 - скидка 100 руб\n" +
                "Покупка более 10.001 - скидка 5%\n\n" +
                "Введите сумму покупки:"
    )
    //храним сумму, введённую пользователем
    val purchase = readln().toInt()

    println("Вы являетесь постоянным покупателем? да/нет")
    //храним ответ о постоянном пользователе - 1%
    val questionUser: Boolean = readln() == "да"

    //покупка до 1_000р и -1% если регулярный пользователь
    if (purchase < discountFirst) {
        result = purchase
        if (questionUser) println("$regularUser ${purchase - purchase / 100} руб.") else println("$unRegularUser $result руб.")
    }
    //покупка от 1_000р до 10_000р и -1% если регулярный пользователь
    else if (purchase in discountFirst..discountSecond) {
        result = purchase - discount
        if (questionUser) println("$regularUser ${result - result * 1 / 100} руб.") else println("$unRegularUser $result руб.")
    }
    //покупка свыше 10_000р и -1% если регулярный пользователь
    else if (purchase > discountSecond) {
        result = purchase - (purchase * 5 / 100)
        if (questionUser) println("$regularUser ${result - result * 1 / 100} руб.") else println("$unRegularUser $result руб.")
    }
}