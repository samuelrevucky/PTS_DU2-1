package datatypes

data class ConnectionData(
    val from: StopName,
    val to: StopName,
    val startTime: Time,
    val arrivalTime: Time
)
