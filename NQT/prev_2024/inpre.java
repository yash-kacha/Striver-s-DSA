

public class inpre {

    static void buildPre(int[] in, int[] post, int inStart, int inEnd, int[] postIndex) {
        if (inStart > inEnd) {
            return;
        }

        // Root from postorder
        int rootVal = post[postIndex[0]--];
        System.out.print(rootVal + " "); // Preorder print

        // Find root in inorder
        int pos = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                pos = i;
                break;
            }
        }

        // IMPORTANT: right first, then left
        buildPre(in, post, pos + 1, inEnd, postIndex);
        buildPre(in, post, inStart, pos - 1, postIndex);
    }

    public static void main(String[] args) {
        int[] in = {4, 2, 5, 1, 3};
        int[] post = {4, 5, 2, 3, 1};

        int[] postIndex = {post.length - 1};

        buildPre(in, post, 0, in.length - 1, postIndex);
    }
}
