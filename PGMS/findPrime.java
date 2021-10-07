public class findPrimes {
    public static void main(String[] args) {
        String numbers = "011";
        solution(numbers);
        System.out.println(answer);
    }
    static int answer = 0;
    static ArrayList<Integer> numList = new ArrayList<>();
    public static int solution(String numbers){
        char[] number = numbers.toCharArray();
        boolean[] visited = new boolean[number.length];
        for(int i=1; i <= number.length; i++){
            make(number, i, visited,"");
        }
        return answer;
    }

    public static void make(char[] number,  int n,boolean[] visited, String num){
        if(n == num.length()) {
            int tmp = Integer.valueOf(num);
            if(!numList.contains(tmp)){
                numList.add(tmp);
                isPrime(num);
                return;
            }
        }

        for(int i= 0; i < number.length; i++){
            if(!visited[i]){
                visited[i] = true;
                make(number, n, visited,num + number[i]);
                visited[i] = false;
            }
        }
    }

    public static void isPrime(String num){
        int n = Integer.valueOf(num);
        if(n < 2) return;
        for(int i=2; i*i <= n; i++){
            if(n % i == 0) return;
        }

        answer++;
    }
}