(ns allergies)

(def item-value {:eggs         1
                 :peanuts      2
                 :shellfish    4
                 :strawberries 8
                 :tomatoes     16
                 :chocolate    32
                 :pollen       64
                 :cats         128})

(defn allergic-to?
  "Returns true if the score indicates an allergy to the allergen;
  otherwise, it returns false."
  [score allergen]
  (pos? (bit-and score (allergen item-value))))

(defn allergies
  "Returns all allergens associated with the score."
  [score]
  (reduce (fn [acc item]
            (if (pos? (bit-and (last item) score))
              (conj acc (first item))
              acc))
          []
          (seq item-value)))

(defn allergies
  [score]
  (->> item-value
       keys
       (filter #(allergic-to? score %))))

