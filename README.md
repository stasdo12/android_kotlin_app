# Android Kotlin App Readme

This is an Android app developed using the Kotlin programming language. The app allows users to register and log in, view a list of items, and purchase items. It also integrates the Razorpay payment gateway for making payments.

## Project Structure

The project consists of several Kotlin files and layout files, organized as follows:

### Activities

1. **MainActivity**: This activity is the entry point of the app and allows users to register with their login, email, and password. Users can also navigate to the login screen from here.

2. **AuthActivity**: This activity is responsible for user authentication. Users can log in using their login and password, or navigate back to the registration screen.

3. **ItemsActivity**: This activity displays a list of items. Users can click on an item to view its details and purchase it.

4. **ItemActivity**: This activity displays the details of an item and allows users to make a payment using Razorpay.

### Adapters

1. **ItemsAdapter**: This RecyclerView adapter is used in the `ItemsActivity` to populate the list of items.

### Database

1. **DbHelper**: This class manages the SQLite database for the app. It includes methods for creating tables, adding users, and authenticating users.

### Data Classes

1. **User**: This data class represents a user with properties for login, email, and password.

2. **Item**: This data class represents an item with properties for ID, image, title, description, text, and price.

### Layout Files

1. **activity_main.xml**: Layout for the main registration screen.

2. **activity_auth.xml**: Layout for the login screen.

3. **activity_items.xml**: Layout for the item list screen.

4. **activity_item.xml**: Layout for the item details screen.

5. **item_in_list.xml**: Layout for individual items in the item list.

### Razorpay Integration

The app includes Razorpay integration to process payments for item purchases. Payment success and error handling is implemented in the `ItemActivity`.

## How to Run the App

1. Clone or download the project source code.

2. Open the project in Android Studio.

3. Build and run the app on an Android emulator or a physical device.

4. You can register a new user on the main screen, or log in with an existing user on the login screen.

5. On the items screen, you can view a list of items, click on an item to view its details, and make a payment using Razorpay.

## Dependencies

The app uses the Razorpay payment gateway, and it requires an active Razorpay account with API keys to process payments. Make sure to replace the API key in the `ItemActivity` with your own API key.

### Disclaimer

This README provides an overview of the Android Kotlin app's structure and functionality. It assumes that you have some knowledge of Android app development and Kotlin programming. You may need to set up the development environment, configure the project, and make necessary adjustments to run the app successfully.
