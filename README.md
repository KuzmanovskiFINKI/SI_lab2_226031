# Втора лабораториска вежба по Софтверско инженерство
## Стефан Кузмановски бр. на индекс 226031

### Control Flow Graph
![CFG (1)](https://github.com/KuzmanovskiFINKI/SI_lab2_226031/assets/130047482/47d2fa08-72f6-4fed-ba78-48c4c42af807)

### Cyclomatic Complexity
Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.
Друг начин на пресметување е бројот на региони на CFG. Во CFG има 10 региони.
Друг начин на пресметување е бројот на ребра E минус бројот на јазли N + 2, односно 33-25+2=10

### EveryBranch тест случаи
Items used for testing:

Item1={name="Item1",barcode="0123456",price="350",discount="0.1f"}\
Item2={name="Item2",barcode="654321",price="10",discount="0"}\
Item3={name=null,barcode="111111",price="300",discount="0.4f"}\
Item4={name="Item4",barcode="1234a6",price="400",discount="0.4f"}\
Item5={name="Item5",barcode=null,price="400",discount="0.4f"}\
Item6={name="Item6",barcode="",price="400",discount="0.4f"}

Branches that need to be tested:\
![image](https://github.com/KuzmanovskiFINKI/SI_lab2_226031/assets/130047482/45a7c81b-0c43-4ea3-90b4-ae87ea98d8ab)



### MultipleCondition тест случаи
![image](https://github.com/KuzmanovskiFINKI/SI_lab2_226031/assets/130047482/adae2f86-a669-418f-aa17-cbc1faff1465)

### Објаснување на Unit Tests
Имаме 2 функции за Unit Testing, една за EveryBranch и една за MultipleCondition
* #### EveryBranch testing:
  *   Test 1 кој тестира внес кога allItems=null
  *   Test 2 кој тестира невалиден карактер во баркод
  *   Test 3 кој тестира внес на празна листа allItems=[]
  *   Test 4 кој тестира item кој има null баркод
  *   Test 5 кој тестира кога sum > payment
  *   Дополнителен Test 6 кој тестира sum<=payment но за листа која не е празна
* ### MultipleCondition testing:
  *   Test 1 кој тестира за TTT
  *   Test 2 кој тестира за TTF
  *   Test 3 кој тестира за TFX
  *   Test 4 кој тестира за FXX




