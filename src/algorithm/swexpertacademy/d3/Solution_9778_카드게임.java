package algorithm.swexpertacademy.d3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution_9778_카드게임 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] cards = new int[12];
        	int sum = 0;
        	for (int i = 0; i < N; i++) {
				sum = sum + Integer.parseInt(br.readLine());
			}
        	int count = 0;
        	for (int i = 2; i < 12; i++) {
				if((i >= 2 && i <= 9 || i == 11)  && cards[i] < 4) {
					if(sum + i > 21) {
						count += 4 - cards[i];
					}
					continue;
				}
				
				if(i == 10 && cards[i] < 16) {
					if(sum + i > 21) {
						count += 16 - cards[i];
					}
					continue;
				}
			}
        	if(52 - N - count <= count) {
        		bw.write("#" + tc + " STOP\n");
        	}else {
        		bw.write("#" + tc + " GAZUA\n");
        	}
        }
        bw.flush();
        bw.close();
        br.close();
    }
}