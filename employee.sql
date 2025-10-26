CREATE TABLE public.person (
    person_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL
);

-- Passport table (One-to-One)
CREATE TABLE public.passport (
    passport_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    person_id UUID UNIQUE NOT NULL,  -- ensures one-to-one
    passport_number VARCHAR(20) NOT NULL,
    issue_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
        REFERENCES public.person (person_id)
        ON DELETE CASCADE
);

-- Address table (One-to-Many)
CREATE TABLE public.address (
    address_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    person_id UUID NOT NULL,  -- one person can have multiple addresses
    street VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    postal_code VARCHAR(10),
    CONSTRAINT fk_address_person
        FOREIGN KEY (person_id)
        REFERENCES public.person (person_id)
        ON DELETE CASCADE
);
