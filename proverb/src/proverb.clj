(ns proverb
  (:require [clojure.string :as str]))

(def saying ["For want of a " " the " " was lost."])

(defn inputs->proverb [[a b]]
  (str (saying 0) a (saying 1) b (saying 2)))

(defn recite [inputs]
  (if (empty? inputs)
    ""
    (str/join "\n" (conj (loop [in inputs
                                text []]
                           (if (< (count in) 2)
                             text
                             (recur (drop 1 in) (conj text (inputs->proverb (take 2 in))))))
                         (str "And all for the want of a " (first inputs) ".")))))


(defn recite [inputs]
  (if (empty? inputs)
    ""
    (->> inputs
         (partition 2 1)
         (map inputs->proverb)
         (#(concat % [(str "And all for the want of a " (first inputs) ".")]))
         (str/join "\n"))))