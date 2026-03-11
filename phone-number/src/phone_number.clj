(ns phone-number)

(def INVALID "0000000000")

(defn number
  [s]
  (let [digits-only (clojure.string/replace s #"[^\d]" "")
        without-country-code (clojure.string/replace digits-only #"^1(\d{10})$" "$1")]
    (if (re-matches #"^[2-9]\d{2}[2-9]\d{6}$" without-country-code)
      without-country-code
      INVALID)))




;; Rules:

;; 10-digit numbers
;; [+1|1] NXX NXX-XXXX
;; N = [2-9]


;; NANP Rules:

;; NXX - 3-digit area code
;; NXX-XXXX - 7-digit local number (3-digit exchange-code '-' 4-digit subscriber number)


