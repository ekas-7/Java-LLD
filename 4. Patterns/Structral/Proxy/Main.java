import java.util.HashMap;
import java.util.Map;

public class Main {

    public interface VideoServiceInterface {
        void playVideo(String ut, String vn);
    }

    public static class RealVideoService implements VideoServiceInterface {
        @Override
        public void playVideo(String ut, String vn) {
            System.out.println("Streaming video: " + vn);
        }
    }

    public static class ProxyVideoService implements VideoServiceInterface {
        private RealVideoService rvs;
        private Map<String, String> cv = new HashMap<>();
        private Map<String, Integer> rc = new HashMap<>();

        public ProxyVideoService(RealVideoService rvs) {
            this.rvs = rvs;
        }

        @Override
        public void playVideo(String ut, String vn) {
            if (!ut.equals("premium") && vn.startsWith("Premium")) {
                System.out.println(
                        "Access denied: Premium video requires a premium account.");
                return;
            }

            rc.put(ut, rc.getOrDefault(ut, 0) + 1);
            if (rc.get(ut) > 5) {
                System.out.println("Access denied: Too many requests.");
                return;
            }

            if (cv.containsKey(vn)) {
                System.out.println("Streaming cached video: " + vn);
            } else {
                rvs.playVideo(ut, vn);
                cv.put(vn, vn);
            }
        }
    }

    public static void main(String[] args) {
        RealVideoService rs = new RealVideoService();
        ProxyVideoService ps = new ProxyVideoService(rs);

        ps.playVideo("free", "Free Video 1");

        ps.playVideo("premium", "Premium Video 1");

        ps.playVideo("guest", "Video 1");

        for (int i = 0; i < 6; i++) {
            ps.playVideo("free", "Free Video 2");
        }
    }
}