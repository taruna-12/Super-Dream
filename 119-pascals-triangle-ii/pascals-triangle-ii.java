import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        
        // Initialize with 1s
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
        }
        
        // Update values from right to left
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}