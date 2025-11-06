(ns eliuds-eggs)

(defn- decimal->binary [decimal]
  (loop [n decimal
         binary '()]
    (if (= n 0)
      binary
      (recur (quot n 2)
             (conj binary (mod n 2))))))

(defn egg-count
  "Returns the number of 1 bits in the binary representation of the given number."
  [num]
  (->> num
       decimal->binary
       (filter #{1})
       count))

;; or..

(defn egg-count [number]
  (count (filter #{\1} (Integer/toString number 2))))

;; or..

(defn egg-count [number]
  (if (= number 0)
    0
    (+ (mod number 2) (egg-count (quot number 2)))))

