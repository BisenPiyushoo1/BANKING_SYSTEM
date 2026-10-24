import { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "../styles/Register.css";

function Register() {
  const [fullName, setFullName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();

    setMessage("");
    setError("");

    // Frontend password validation
    if (password !== confirmPassword) {
      setError("Passwords do not match");
      return;
    }

    setLoading(true);

    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/register",
        {
          userName: fullName,
          email: email,
          password: password,
          verify_password: confirmPassword,
        }
      );

      console.log("Register response:", response.data);

      setMessage("Account created successfully!");

      // Clear form
      setFullName("");
      setEmail("");
      setPassword("");
      setConfirmPassword("");

    } catch (err) {
      console.error("Registration error:", err);

      if (err.response) {
        setError(
          typeof err.response.data === "string"
            ? err.response.data
            : "Registration failed. Please check your details."
        );
      } else {
        setError("Unable to connect to the server.");
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="register-page">

      {/* LEFT SIDE */}
      <section className="register-hero">

        <div className="brand">
          <div className="brand-logo">T</div>
          <span>TrustPay</span>
        </div>

        <div className="hero-content">

          <p className="eyebrow">JOIN TRUSTPAY</p>

          <h1>
            Banking made
            <br />
            <span>simple & secure.</span>
          </h1>

          <p className="hero-text">
            Create your TrustPay account and manage your money
            with a simple, secure and modern banking experience.
          </p>

        </div>

        <div className="security-box">

          <div className="security-icon">✓</div>

          <div>
            <strong>Your security matters</strong>

            <p>
              Your account information is protected with
              secure authentication.
            </p>
          </div>

        </div>

      </section>

      {/* RIGHT SIDE */}
      <section className="register-section">

        <div className="register-card">

          <div className="mobile-brand">
            <div className="brand-logo">T</div>
            <span>TrustPay</span>
          </div>

          <h2>Create your account</h2>

          <p className="subtitle">
            Get started with your secure banking account.
          </p>

          <form onSubmit={handleSubmit}>

            {/* FULL NAME */}
            <div className="form-group">

              <label htmlFor="fullName">
                Full name
              </label>

              <input
                id="fullName"
                type="text"
                placeholder="Enter your full name"
                value={fullName}
                onChange={(e) => setFullName(e.target.value)}
                required
              />

            </div>

            {/* EMAIL */}
            <div className="form-group">

              <label htmlFor="email">
                Email address
              </label>

              <input
                id="email"
                type="email"
                placeholder="Enter your email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />

            </div>

            {/* PASSWORD */}
            <div className="form-group">

              <label htmlFor="password">
                Password
              </label>

              <input
                id="password"
                type="password"
                placeholder="Create a password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />

            </div>

            {/* CONFIRM PASSWORD */}
            <div className="form-group">

              <label htmlFor="confirmPassword">
                Confirm password
              </label>

              <input
                id="confirmPassword"
                type="password"
                placeholder="Confirm your password"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                required
              />

            </div>

            {/* TERMS */}
            <label className="terms">

              <input
                type="checkbox"
                required
              />

              <span>
                I agree to the Terms of Service and Privacy Policy.
              </span>

            </label>

            {/* ERROR */}
            {error && (
              <p className="form-error">
                {error}
              </p>
            )}

            {/* SUCCESS */}
            {message && (
              <p className="form-success">
                {message}
              </p>
            )}

            {/* REGISTER BUTTON */}
            <button
              type="submit"
              className="register-button"
              disabled={loading}
            >
              {loading ? "Creating account..." : "Create account"}
            </button>

          </form>

          <div className="divider">
            <span>OR</span>
          </div>

          <p className="login-text">

            Already have an account?

            <Link
              to="/login"
              className="login-link"
            >
              Sign in
            </Link>

          </p>

        </div>

      </section>

    </div>
  );
}

export default Register;

