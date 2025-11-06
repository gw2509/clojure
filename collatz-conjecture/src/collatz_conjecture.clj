(ns collatz-conjecture)


(defn collatz
  "Returns the number of steps for num to reach 1
  according to the Collatz Conjecture."
  [num]
  (loop [n num
         c 0]
    (if (== n 1)
      c
      (if (even? n)
        (recur (/ n 2) (inc c))
        (recur (+ (* n 3) 1) (inc c))))))

(defn collatz-2
  [num]
  (prn num)
  (cond
    (= 1 num) 0
    (even? num) (+ 1 (collatz-2 (/ num 2)))
    (odd? num) (+ 1 (collatz-2 (+ (* num 3) 1)))))


(collatz 12)
(collatz-2 12)