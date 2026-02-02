(ns prime-factors)

(defn of
  "Returns the prime factors of the given number."
  [n]
  (loop [factors []
         n n
         divisor 2]
    (if (> n 1)
      (cond
        (> divisor (Math/sqrt n))
        (conj factors n)
        (= 0 (mod n divisor))
        (recur (conj factors divisor)
               (quot n divisor)
               divisor)
        :else
        (recur factors n (inc divisor)))
      factors)))


