// Морской бой. Часть 01: игровое поле и функции.
// Темы: двумерные массивы, вложенные циклы, функции (устранение дублирования кода).
//
// Поле — квадрат 10×10. Клетка: '.' — пусто, '#' — палуба корабля.

// Создаёт пустое поле 10×10, заполненное точками.
// Array(10) { CharArray(10) { '.' } } — внешний массив строки, внутренний столбцы.
fun createField(): Array<CharArray> = Array(10) { CharArray(10) { '.' } }

// Печатает ОДНО поле с заголовком и нумерацией строк/столбцов.
// Раньше этот блок дублировался — теперь у него есть имя, и его можно вызывать сколько угодно раз.
fun printField(field: Array<CharArray>, title: String) {
    println("=== $title ===")
    print("    ")                       // отступ под номера столбцов
    for (c in 0..9) print("$c ")        // шапка: номера столбцов
    println()
    for (r in 0..9) {                   // внешний цикл — по строкам
        print("$r   ")                  // номер строки слева
        for (c in 0..9) print("${field[r][c]} ")   // внутренний цикл — по столбцам
        println()
    }
}

// Печатает ДВА поля рядом, в одну строку экрана — как в настоящем морском бое.
fun printBothFields(playerField: Array<CharArray>, enemyField: Array<CharArray>) {
    println("=== Ваше поле ===                    === Поле противника ===")
    print("    "); for (c in 0..9) print("$c "); print("         ")
    print("    "); for (c in 0..9) print("$c "); println()
    for (r in 0..9) {
        print("$r   ")
        for (c in 0..9) print("${playerField[r][c]} ")
        print("        ")               // отступ между полями
        print("$r   ")
        for (c in 0..9) print("${enemyField[r][c]} ")
        println()
    }
}

fun main() {
    // создаём два поля
    val playerField = createField()
    val enemyField = createField()

    // ставим корабли (палуба — '#'); обращение к клетке: field[строка][столбец]
    playerField[3][2] = '#'
    playerField[3][3] = '#'
    playerField[3][4] = '#'
    playerField[3][5] = '#'

    enemyField[5][7] = '#'
    enemyField[6][7] = '#'
    enemyField[7][7] = '#'

    // печатаем оба поля рядом — одним вызовом функции
    printBothFields(playerField, enemyField)
}
