package ru.geekbrains.junior.lesson1.task2;

import java.util.Scanner;

public class Program {

    /*
    Задача 2: Техническое задание на разработку информационной системы UMarket
    Вам доверено спроектировать и реализовать классы предметной области,
    которые позволят в дальнейшем вести разработку ИС со следующим функционалом:

    1. Осуществлять учет продовольственных и непродовольственных товаров, которыми торгует UMarket.

    2. Предоставлять покупателям возможность фильтрации продовольственных товаров по следующим видам:
        • Снеки;
        • Полуфабрикаты;
        • Продукты для приготовления;
        • Все продовольственные товары.
    3. Формировать онлайн корзину из продовольственных товаров.
    4. Осуществлять балансировку онлайн корзины с целью получения такого набора продуктов питания,
        который включает все основные питательные элементы.


    Особенности бизнес-логики сервиса UMarket.

    Модуль онлайн покупок должен осуществлять контроль за попадающими в покупательскую корзину продуктами, а именно:
        • в онлайн корзину можно добавить только продовольственные товары;
        • в зависимости от желания покупателя, в онлайн корзине могут находиться как все присутствующие в UMarket
          продовольственные товары, так и исключительно товары той категории,
          которую выбрал покупатель посредством настроек фильтрации (фильтрация по видам продовольственных товаров).

    Необходимо предусмотреть типобезопасность онлайн корзины, так как в момент «автоматической балансировки» она
    должна пополняться продовольственными товарами из списка товаров UMarket.
    Необходимо учесть, что в случае формирования онлайн корзины конкретного вида продовольственных товаров,
    дополнять корзину необходимо товарами именно из выбранной покупателем категории продовольственных товаров.

    С целью упрощения алгоритма балансировки онлайн корзины, будем считать, что каждый продовольственный
    продукт содержит всего лишь один питательный элемент: белки / жиры / углеводы.
    Следовательно, есть вероятность, что все выбранные товары будут представителями
    одного и того же питательного элемента (например, углеводными).
    В свою очередь, балансировка делает так, чтобы в корзине были представлены все питательные элементы.

    */

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ru.geekbrains.junior.lesson1.task2.UMarket market = new ru.geekbrains.junior.lesson1.task2.UMarket();
        System.out.println("Добро пожаловать в магазин U-Market");

        while (true)
        {
            System.out.println("================================================================");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("1 - Отобразить полный список товаров");
            System.out.println("2 - Сформировать онлайн корзину из снеков");
            System.out.println("3 - Сформировать онлайн корзину из полуфабрикатов");
            System.out.println("4 - Сформировать онлайн корзину из продуктов для приготовления");
            System.out.println("5 - Сформировать онлайн корзину из любых продовольственные товаров");
            System.out.println("Выберите пункт меню: ");

            if (scanner.hasNextInt())
            {
                int no = scanner.nextInt();
                scanner.nextLine();

                switch (no) {
                    case 0 -> {
                        System.out.println("Завершение работы приложения.");
                        return;
                    }
                    case 1 -> {
                        System.out.println("Список товаров:");
                        market.printThings(ru.geekbrains.junior.lesson1.task2.Thing.class);
                    }
                    case 2 -> CreateCart(ru.geekbrains.junior.lesson1.task2.Snack.class, market);
                    case 3 -> CreateCart(ru.geekbrains.junior.lesson1.task2.SemiFinishedFood.class, market);
                    case 4 -> CreateCart(ru.geekbrains.junior.lesson1.task2.HealthyFood.class, market);
                    case 5 -> CreateCart(ru.geekbrains.junior.lesson1.task2.Food.class, market);
                }

            }
            else{
                System.out.println("Некорректный пункт меню.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }

        }

    }

    static <T extends ru.geekbrains.junior.lesson1.task2.Food> void CreateCart(Class<T> clazz, ru.geekbrains.junior.lesson1.task2.UMarket market)
    {
        ru.geekbrains.junior.lesson1.task2.Cart<T> cart = new ru.geekbrains.junior.lesson1.task2.Cart<>(clazz, market);
        while (true)
        {
            System.out.println("Список доступных товаров:");
            System.out.println("[0] Завершение формирования корзины + балансировка");
            market.printThings(clazz);
            System.out.print("Укажите номер товара для добавления: ");
            if (scanner.hasNextInt())
            {
                int no = scanner.nextInt();
                scanner.nextLine();

                if (no == 0) {
                    cart.cardBalancing();
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuffs();
                    return;
                }
                else {
                    T thing = market.getThingByIndex(clazz, no);
                    if (thing == null) {
                        System.out.println("Некорректный номер товара.\nПожалуйста, повторите попытку ввода.");
                        continue;
                    }
                    cart.getFoodstuffs().add(thing);
                    System.out.println("Товар успешно добавлен в корзину.");
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuffs();
                }

            }
            else{
                System.out.println("Некорректный пункт меню.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
    }

}
