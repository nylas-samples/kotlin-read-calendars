// Import Nylas packages
import com.nylas.NylasClient
import com.nylas.models.*
import com.nylas.resources.Calendars

// Import DotEnv to handle .env files
import io.github.cdimascio.dotenv.dotenv

fun main(args: Array<String>) {
    // Load our env variable
    val dotenv = dotenv()

    // Initialize Nylas client
    val nylas: NylasClient = NylasClient(
        apiKey = dotenv["V3_TOKEN"],
        apiUri = dotenv["NYLAS_API_SERVER"],
    )

    // Set the event parameters
    val calendarQueryParams: ListCalendersQueryParams = ListCalendersQueryParams()
    // Read calendars
    val calendars: List<Calendar> = nylas.calendars().list(dotenv["CALENDAR_ID"], calendarQueryParams).data
    for(calendar in calendars){
        print("Id: " + calendar.id +
              " | Name: " + calendar.name +
              " | Description: " + calendar.description)
        println("\n")
    }
}
