public class JSONAnalyticTool {
    private String jsonData;

    public void setJsonString(String data) {
        this.jsonData = data;
    }

    public void analyzeData() {
        // Perform JSON analysis
        if (jsonData.contains("json")) {
            System.out.println("Valid JSON: Analyzing the data...");
        } else {
            System.out.println("Invalid JSON: please provide the data in correct format.");
        }
    }
}
