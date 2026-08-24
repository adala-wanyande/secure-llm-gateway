import re

class SanitizationService:
    @staticmethod
    def sanitize_pii(text: str) -> str:
        if not text:
            return ""
        
        # Regex to mask a 9-digit Bank Account Number or SSN
        # Example: 123456789 becomes *****6789
        sanitized_text = re.sub(r'\b(\d{5})(\d{4})\b', r'*****\2', text)
        
        return sanitized_text