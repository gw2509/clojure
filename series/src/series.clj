(ns series)

(defn validate [s n]
  (cond
    (empty? s) (throw (IllegalArgumentException. "series cannot be empty"))
    (< n 0) (throw (IllegalArgumentException. "slice length cannot be negative"))
    (= n 0) (throw (IllegalArgumentException. "slice length cannot be zero"))
    (> n (count s)) (throw (IllegalArgumentException. "slice length cannot be greater than series length"))))

;; my solution

(defn do-slicing
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  (or (validate s n)
      (loop [result []
             rem s]
        (if (> n (count rem))
          result
          (recur (conj result (apply str (take n rem))) (rest rem))))))

;; using partition

(defn do-slicing [s n]
  (map #(apply str %) (partition n 1 s)))


(defn slices
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  (or (validate s n)
      (do-slicing s n)))