public class XmlToJsonAdapter implements AnalyticalTool {
    private JSONAnalyticTool jsonAnalyticTool;

    public XmlToJsonAdapter(String data) {
        System.out.println("Converting XML to JSON...");
        String newData = data + " json";
        jsonAnalyticTool = new JSONAnalyticTool();
        jsonAnalyticTool.setJsonString(newData);
        // Simulating XML to JSON conversion
    }

    @Override
    public void analyzeData() {
        jsonAnalyticTool.analyzeData();
    }

}
