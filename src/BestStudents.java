import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

class TestResult
{
	int 		studentId;
	String 	data;
	int 		score;
}

class TestResultComparator implements Comparator<TestResult>
{
	@Override
	public int compare(TestResult o1, TestResult o2) {
		return o1.score - o2.score;
	}
}

//n + klgn, n
//k + (n-k)lgk, k
public class BestStudents
{
	public static Map<Integer, Double> calculateFinalScore(ArrayList<TestResult> results)
	{
		PriorityQueue<TestResult> heap 
			= new PriorityQueue<TestResult>(10, new TestResultComparator());
		heap.addAll(results);
		return null;
	}
}
