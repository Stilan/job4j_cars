Модели и связи. Машины и владельцы
1. One-to или to-one.

Связь one-to или to-one осуществляется за счет добавление вторичного ключа в основную таблицу.

Через аннотацию
@ManyToOne
@JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
private Engine engine;

2. Many-to-many.

Связь many-to-many осуществляется за счет вспомогательной таблицы.

Аннотации
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "history_owner", joinColumns = {
@JoinColumn(name = "driver_id", nullable = false, updatable = false)},
inverseJoinColumns = {
@JoinColumn(name = "car_id", nullable = false, updatable = false)})
private Set<Driver> drivers = new HashSet<>();

