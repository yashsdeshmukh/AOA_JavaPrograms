package aoaPrograms;
import java.util.*;
import java.io.IOException;
public class UniqueTenDigitMeetingId {

	static void MeetingIdASCII()
    {
		String str = UUID.randomUUID().toString();
        int l = str.length();
        int convert;
        for (int i = 0; i < l; i++) {
            convert = str.charAt(i);
            System.out.print(convert);
        }
    }
	
	public static int function(ArrayList<Integer> Ids) throws IOException {
		Random rand = new Random();
		int meetingId  = rand.nextInt(999999999);
		System.out.println(meetingId);
		if(!Ids.contains(meetingId)) {
			Ids.add(meetingId);
			return 1;
		}
		else {
			System.out.println(Ids.size());
//			Scanner sc = new Scanner(System.in);
//			int n = sc.nextInt();
			if(Ids.size()>100000){
				System.out.println(Ids.size());
			}
		}
		return 0;
	}
	
	public static void main (String[] args) throws IOException {
		ArrayList<Integer> Ids = new ArrayList<Integer>();
		int i=0;
		MeetingIdASCII();
//		while(true) {
//			function(Ids);
//			i++;
//			System.out.println(i);
//		}
		
	}
	
}
