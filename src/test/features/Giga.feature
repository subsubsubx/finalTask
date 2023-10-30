@all
@gigabyte
Feature: Проверяем наличие на сайте карточек от вендора гигабайт

  Scenario: Открыть регард, Каталог>Периферия, выбрать грид с текстовкой "Мыши", выбрать видеокарту от 20к рублей
    Given Клик на каталог
    And Выбор "Комплектующие для ПК"
    And Выбор "Видеокарты" в гриде
    And Установка минималки 20000
    And Выбираем вендора "Gigabyte"
    And Убеждаемся что количество результатов поиска меньше или равно 24
    And Сохраняем наименование результата номер 1 из списка, вводим в серч бар сверху его значение
    And Убеждаемся что количество результатов поиска меньше или равно 1
    And Получаем наименование 1 результата из списка и сравниваем его с введенным значением в серч баре