(ns hamming)

(defn distance
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (let [pairs (map vector strand1 strand2)]
      (apply + (map #(if (= (first %) (last %)) 0 1) pairs)))
    (throw (IllegalArgumentException. "strands must be of equal length"))))


(defn distance
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (if (not= (count strand1) (count strand2))
    (throw (IllegalArgumentException. "strands must be of equal length"))
    (count (filter false? (map #(= %1 %2) strand1 strand2)))))