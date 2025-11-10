(ns square-root)


(defn square-root
  "Calculates the square root of a number."
  [num]
  (loop [guess (/ num 2)
         n 10000]
    (let [next-guess (/ (+ guess (/ num guess)) 2)]
      (if (or (< (abs (- guess next-guess)) 0.01)
              (= n 0))
        (int next-guess)
        (recur next-guess (dec n))))))


(defn square-root
  "Calculates a number's square root"
  [n]
  (loop [i 1]
    (prn i)
    (if (<= (* i i) n)
      (recur (inc i))
      (dec i))))