class Solution {

    /*
    =========================================================
    🧠 PROBLEM: Process String with operations (#, %, *)
    =========================================================

    You are given a string s and a number k.

    Operations:
    - a-z → append character
    - *   → delete last character
    - #   → duplicate string
    - %   → reverse string

    Goal:
    👉 Find k-th character after all operations

    =========================================================
    🧠 KEY IDEA (IMPORTANT)
    =========================================================

    ❌ DO NOT build full string (MLE risk)

    ✔ Step 1: compute final length only
    ✔ Step 2: walk backwards to find k-th character

    =========================================================
    🔥 DRY RUN EXAMPLE
    =========================================================

    Input:
        s = "a#b%c*"
        k = 2

    ---------------------------------------------------------
    STEP 1: FORWARD PASS (ONLY LENGTH)
    ---------------------------------------------------------

    Start:
        len = 0

    a → len = 1        (a)
    # → len = 2        (aa)
    b → len = 3        (aab)
    % → len = 3        (baa)
    c → len = 4        (baac)
    * → len = 3        (baa)

    Final:
        len = 3

    Imaginary string:
        index: 0 1 2
        value:  b a a

    We want k = 2 → 'a'

    ---------------------------------------------------------
    STEP 2: BACKWARD PASS
    ---------------------------------------------------------

    Start:
        len = 3, k = 2

    '*' → undo delete → len = 4
    'c' → skip → len = 3
    '%' → reverse:
            k = len - 1 - k
            k = 2 - 2 = 0
    'b' → skip → len = 2
    '#' → undo duplicate:
            len = 1
            k = 0 % 1 = 0
    'a' → MATCH → return 'a'

    =========================================================
    🎯 FINAL ANSWER = 'a'
    =========================================================
    */

    public char processStr(String s, long k) {

        long len = 0;
        int n = s.length();

        // STEP 1: compute final length
        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len++;
            }

            else if (c == '*') {
                if (len > 0) len--;
            }

            else if (c == '#') {
                len = len * 2;
            }

            // '%' does not change length
        }

        // if k is out of range
        if (k >= len) return '.';

        // STEP 2: reverse traversal
        for (int i = n - 1; i >= 0; i--) {

            char c = s.charAt(i);

            // normal character
            if (c >= 'a' && c <= 'z') {

                if (len - 1 == k) {
                    return c; // found answer
                }

                len--;
            }

            // delete operation
            else if (c == '*') {
                len++;
            }

            // duplication
            else if (c == '#') {

                len /= 2;

                // map k into first half
                k = k % len;
            }

            // reverse operation
            else if (c == '%') {

                k = len - 1 - k;
            }
        }

        return '.';
    }
}
