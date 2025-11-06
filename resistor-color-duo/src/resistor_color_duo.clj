(ns resistor-color-duo)

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(def color-code
  (zipmap colors (range)))

(defn resistor-value
  "Returns the resistor value based on the given colors"
  [colors]
  (reduce (fn [acc n] (+ (* acc 10) n)) (take 2 (map color-code colors))))

(defn resistor-value
  "Returns the resistor value based on the given colors"
  [colors]
  (let [nums (take 2 (map color-code colors))]
    (+ (* 10 (first nums)) (second nums))))

