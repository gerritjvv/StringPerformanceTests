 (ns string-bench
   (:import [util StringUtils])
   (use perforate.core))


 (defgoal string-bench "String creation benchmark")

 (def iterations 100000)

 (def ^"[C" test-array1 (-> (String. (char-array (map char (range 10)))) .toCharArray))
 (def ^"[C" test-array2 (-> (String. (char-array (map char (range 50)))) .toCharArray))
 (def ^"[C" test-array3 (-> (String. (char-array (map char (range 100)))) .toCharArray))
 (def ^"[C" test-array4 (-> (String. (char-array (map char (range 500)))) .toCharArray))


 (defcase string-bench :default-string-creation-1
          []
          (dotimes [i iterations]
            (String. test-array1)))

(defcase string-bench :unsafe-string-creation-1
         []
         (dotimes [i iterations]
           (StringUtils/noCopyStringFromChars test-array1)))


(defcase string-bench :default-string-creation-2
         []
         (dotimes [i iterations]
           (String. test-array2)))

(defcase string-bench :unsafe-string-creation-2
         []
         (dotimes [i iterations]
           (StringUtils/noCopyStringFromChars test-array2)))


(defcase string-bench :default-string-creation-3
         []
         (dotimes [i iterations]
           (String. test-array3)))

(defcase string-bench :unsafe-string-creation-3
         []
         (dotimes [i iterations]
           (StringUtils/noCopyStringFromChars test-array3)))


(defcase string-bench :default-string-creation-4
         []
         (dotimes [i iterations]
           (String. test-array4)))

(defcase string-bench :unsafe-string-creation-4
         []
         (dotimes [i iterations]
           (StringUtils/noCopyStringFromChars test-array4)))