## Database service for `techno-kitchen` beta version.
**Задача** - реализовать свервис, который будет принимать с сайта(**от сервиса [`User-Request-Service`](https://github.com/IlyaVysokolyan/User-Request-Service)**) запросы от пользователей и обрабатывать их.
- Структура проекта:
  - Model
  - DTO
  - Interfaces (**контракты на общие операции Сервиса и Контроллеров**)
  - Mapper
  - Repository
  - Service
  - Controllers
  - Specification(**классы отвечающие за фильтрацию**)

### Возможности:
- Сбор статистики(object - `StatisticOb`):
  - Топ 3 сборки/Топ 3 GPU/Топ 3 RAM
  - Свод остатков в разрезе каждой коплектующей + общая стоимость остатков (**[см. README `UserRequestService`](https://github.com/IlyaVysokolyan/User-Request-Service)**)
- Основные операции с комплектующими:
  - Добавление
  - Изменение
  - Удаление
  - Поиск конкретного объекта
  - Фильтрация (`ParamsDto`- принимает параметры, интерфейс `Specification` - обрабатывает параметры)
 - В процессе разработки:
   - Сборка компьютера
   - Фильтрация по типу сборки, т.е. для игр/для офиса/для обучения и прч...
   - Авторизация/Аутентификация (Spring Security)

Структура БД:

<img width="650" alt="Снимок экрана 2024-10-09 в 01 24 23" src="https://github.com/user-attachments/assets/5da6d50d-e3d9-48dc-b43d-4c01755f9c8b">
