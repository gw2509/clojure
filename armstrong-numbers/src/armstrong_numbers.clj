(ns armstrong-numbers)


(defn digits [n]
  (if (< n 10)
    [n]
    (conj (digits (quot n 10)) (rem n 10))))

(defn armstrong?
  "Returns true if the given number is an Armstrong number;
  otherwise, it returns false."
  [num]
  (let [digits (digits num)
        power (count digits)]
    (= num
       (apply + (map #(reduce *' (repeat power (bigint %))) digits)))))


(defn armstrong?
  [n]
  (->> (str n)
       seq
       (map str)
       (map read-string)
       (map #(reduce *' (repeat (count (str n)) %)))
       (reduce +)
       (= n)))