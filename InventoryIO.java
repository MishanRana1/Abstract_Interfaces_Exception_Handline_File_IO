import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

class InventoryIO {
    public static void saveEnergyReport(String path, Collection<? extends MeasurableEnergy> items)
            throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Energy Report (daily estimates)\n");
            bw.write("================================\n");
            for (MeasurableEnergy m : items) {
                String line = m.getClass().getSimpleName() +
                        " -> " + String.format(Locale.US, "%.2f kWh/day", m.kWhPerDay());
                bw.write(line);
                bw.newLine();
            }
        }
    }
}