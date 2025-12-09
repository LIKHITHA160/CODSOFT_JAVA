package currencyconvertor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConvertor {

    // Fetch Rates from API
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            String url = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;

            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Convert API response to JSON
            JSONObject json = new JSONObject(response.toString());
            JSONObject rates = json.getJSONObject("rates");

            return rates.getDouble(targetCurrency);

        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🌍 Welcome to Real-Time Currency Converter");

        // Step 1: Base Currency
        System.out.print("Enter Base Currency (e.g., USD, INR, EUR): ");
        String baseCurrency = sc.next().toUpperCase();

        // Step 2: Target Currency
        System.out.print("Enter Target Currency (e.g., USD, INR, EUR): ");
        String targetCurrency = sc.next().toUpperCase();

        // Step 3: Amount Input
        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        // Step 4: Fetch Real-Time Rate
        double rate = getExchangeRate(baseCurrency, targetCurrency);

        if (rate == -1) {
            System.out.println("❌ Conversion failed. Please check your currency codes.");
            return;
        }

        // Step 5: Convert
        double convertedAmount = amount * rate;

        // Step 6: Show Result
        System.out.println("\n------ Conversion Result ------");
        System.out.println(amount + " " + baseCurrency +
                " = " + convertedAmount + " " + targetCurrency);
        System.out.println("--------------------------------");

        sc.close();
    }
}

